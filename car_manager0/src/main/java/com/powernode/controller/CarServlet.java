package com.powernode.controller;

import com.alibaba.fastjson.JSONObject;
import com.powernode.model.Car;
import com.powernode.service.CarService;
import com.powernode.service.CarServiceM;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : HD
 * @create 2021/12/9 15:48
 */
@WebServlet("/car")
public class CarServlet extends HttpServlet {
    private CarService carService = new CarService();
    private CarServiceM carServiceM = new CarServiceM();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        if ("list".equals(flag)) {
            getByList(request, response);
        } else if ("select".equals(flag)) {
            findByList(request, response);
        } else if ("delete".equals(flag)) {
            removeById(response, request);
        }
    }

    private void removeById(HttpServletResponse response, HttpServletRequest request) {

        String id = request.getParameter("id");
        List<Integer> list = new ArrayList<>();

        if (id != null) {
            list.add(Integer.parseInt(id));
        }

        try {
            String isSucess = carServiceM.removeByIdM(list);
            writeM(response, isSucess);
        } catch (IOException throwables) {
            throwables.printStackTrace();
        }
    }

    private void findByList(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {


        ArrayList<Car> cars = new ArrayList<>();
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        try {
            cars = carService.findByList(brand, color);
            String data = JSONObject.toJSONString(cars);
            writeM(response, data);
        } catch (IOException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    private void getByList(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Car> cars = new ArrayList<>();

        try {
            cars = carService.getByList();
            String data = JSONObject.toJSONString(cars);
            writeM(response, data);
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String number = request.getParameter("number");
        String size = request.getParameter("size");
        String flag = request.getParameter("flag");

        Car car = new Car();
        car.setBrand(brand);
        car.setColor(color);
        car.setNumber(number);
        car.setSize(size);

        try {
            //这里前端没有拿到msg??
            String isSucess = carService.addCar(car);
            if (isSucess.equals("sucess")) {
                request.setAttribute("msg", "保存成功");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }else {
                request.setAttribute("msg", "保存失败");
                request.getRequestDispatcher("/add.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    private  void   writeM(HttpServletResponse response, String data) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(data);
        writer.close();
    }

}
