package controller;

import model.*;
import model.abstract_class.Service;
import service.impl.IService;
import service.impl.ServiceImpl;
import util.CodeCreating;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServletService", value = "/ServletService")
public class ServletService extends HttpServlet {
    IService iService = new ServiceImpl();
    List<ServiceType> typeList =iService.serviceType();
    List<RentType> rentTypes = iService.rentType();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "addRoom":
                addRoom(request,response);
                break;
            default:
                displayService(request,response);
                break;
        }
    }

    private void addRoom(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Service> serviceHashmap = iService.findAll();
        request.setAttribute("listType",typeList);
        request.setAttribute("listRent",rentTypes);
        int id = serviceHashmap.size()+1;
        String code = CodeCreating.setCode("DV-",id);
        request.setAttribute("id",id);
        request.setAttribute("code",code);
        request.setAttribute("doing",0);
        try {
            List<Room> roomList = new ArrayList<>();
            List<House> houseList = new ArrayList<>();
            List<Villa> villaList = new ArrayList<>();

            for(Map.Entry<String, Service> entry : serviceHashmap.entrySet()) {
                String key = entry.getKey();
                Service service = entry.getValue();
                if(key.contains("room")){
                    Room room = new Room();
                    roomList.add((Room) service);
                }else if(key.contains("house")){
                    House house = new House();
                    houseList.add((House) service);
                }else if(key.contains("villa")){
                    Villa villa = new Villa();
                    villaList.add((Villa) service);
                }
            }
            request.setAttribute("roomList",roomList);
            request.setAttribute("houseList",houseList);
            request.setAttribute("villaList",villaList);
            request.getRequestDispatcher("service.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void displayService(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Service> serviceHashmap = iService.findAll();
        //System.out.println(serviceHashmap.size());
        try {
            List<Room> roomList = new ArrayList<>();
            List<House> houseList = new ArrayList<>();
            List<Villa> villaList = new ArrayList<>();

            for(Map.Entry<String, Service> entry : serviceHashmap.entrySet()) {
                String key = entry.getKey();
                Service service = entry.getValue();
                if(key.contains("room")){
                    Room room = new Room();
                    roomList.add((Room) service);
                }else if(key.contains("house")){
                    House house = new House();
                    houseList.add((House) service);
                }else if(key.contains("villa")){
                    Villa villa = new Villa();
                    villaList.add((Villa) service);
                }
            }
            request.setAttribute("roomList",roomList);
            request.setAttribute("houseList",houseList);
            request.setAttribute("villaList",villaList);
            request.getRequestDispatcher("service.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "addRoom":
                addNewRoom(request,response);
                break;
            default:
                displayService(request,response);
                break;
        }
    }

    private void addNewRoom(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        String serviceName = request.getParameter("service-name");
        float area = Float.parseFloat(request.getParameter("area"));
        int maxPeople = Integer.parseInt(request.getParameter("people"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentType"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceType"));
        Room room = new Room(id,code,serviceName,area,0,maxPeople,"",0,serviceTypeId,"",rentTypeId,null);
        iService.add(room);
        try {
            response.sendRedirect("/ServletService");
        } catch (IOException e) {

        }
    }
}
