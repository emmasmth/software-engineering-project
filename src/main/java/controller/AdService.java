package controller;

import model.dao.AdDAO;
import model.entity.Ad;

import java.util.List;

public class AdService
{
    public static AdDAO dao = new AdDAO();

    public static void setDao(AdDAO dao)
    {
        AdService.dao = dao;
    }

    public static List<Ad> listAds(String Order)
    {
        List<Ad> lstAd = dao.list(Order);
        return lstAd;
    }

    public static void deleteAd(int id)
    {
        dao.delete(id);
    }
}
