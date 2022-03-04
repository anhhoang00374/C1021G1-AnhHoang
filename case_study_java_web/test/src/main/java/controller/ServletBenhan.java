package controller;

import dao.BenhanDao;
import dao.BenhnhanDao;
import dao.IBenhanDao;
import dao.IBenhnhanDao;
import model.Benhan;
import model.Benhnhan;
import model.HosoBenhan;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletBenhan", value = "/")
public class ServletBenhan extends HttpServlet {
    IBenhnhanDao iBenhnhanDao = new BenhnhanDao();
    BenhanDao iBenhanDao = new BenhanDao();

    List<HosoBenhan> hosoBenhanList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "delete":
                break;
            case "edit":
                showEdit(request,response);
                break;
            default:
                display(request,response);
                break;
        }
    }

    private  void showEdit(HttpServletRequest request,HttpServletResponse response){
        String ma_benh_an = request.getParameter("id");
        for(HosoBenhan hosoBenhan: hosoBenhanList){
            if(hosoBenhan.getMaBenhAn().equals(ma_benh_an)){
                request.setAttribute("hosobenhan",hosoBenhan);
            }
        }
        try {
            request.getRequestDispatcher("edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "delete":
                break;
            case "edit":
                edit(request,response);
                break;
            default:
                display(request,response);
                break;
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
        String mabenhan = request.getParameter("mabenhan");
        String mabenhnhan = request.getParameter("mabenhnhan");
        String tenbenhnhan = request.getParameter("tenbenhnhan");
        String ngaynhapvien = request.getParameter("ngaynhapvien");
        String ngayravien = request.getParameter("ngayravien");
        String lydonhapvien = request.getParameter("lydonhapvien");
        //for (HosoBenhan hosoBenhan : hosoBenhanList){
        //    if(hosoBenhan.getMaBenhAn().equals(ma_benh_an)){
                Benhan benhan = new Benhan(mabenhan,ngaynhapvien,ngayravien);
                iBenhanDao.updateBenhan(benhan);
                Benhnhan benhnhan = new Benhnhan(mabenhnhan,tenbenhnhan,
                        lydonhapvien,mabenhan);
                iBenhnhanDao.updateBenhnhan(benhnhan);
           // }
        //}
        try {
            response.sendRedirect("/");
            System.out.println(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display(HttpServletRequest request,HttpServletResponse response){
        List<Benhan> benhanDaoList = iBenhanDao.listAllBenhan();
        List<Benhnhan> benhnhanList = iBenhnhanDao.listAllBenhnhan();
        System.out.println(benhanDaoList.size());
        System.out.println(benhnhanList.size());
        hosoBenhanList.clear();
        for(Benhnhan benhnhan :benhnhanList){
            HosoBenhan hosoBenhan = new HosoBenhan();
            System.out.println(benhnhan.getMaBenhnhan()+"benhnhan");
            Benhan benhan = iBenhanDao.findBenhan(benhnhan.getMaBenhnhan());
            System.out.println(benhan.getId()+"123");
            //String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayRaVien, String lyDoNhapVien
            hosoBenhan.setMaBenhAn(benhan.getId());
            hosoBenhan.setMaBenhNhan(benhnhan.getId());
            hosoBenhan.setTenBenhNhan(benhnhan.getTenBenhnhan());
            hosoBenhan.setNgayRaVien(benhan.getNgayRaVien());
            hosoBenhan.setNgayNhapVien(benhan.getNgayNhapVien());
            hosoBenhan.setLyDoNhapVien(benhnhan.getLido());
            hosoBenhanList.add(hosoBenhan);
            System.out.println(benhan);
            System.out.println(benhnhan);
        }
        request.setAttribute("listHosoBenhan",hosoBenhanList);
        System.out.println(hosoBenhanList.size());
        try {
            request.getRequestDispatcher("home.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
