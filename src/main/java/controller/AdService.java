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

    public static Ad editAd(Ad a)
    {
        if(a.getFilename().isEmpty())
        {
            Ad og = dao.read(a.getID());
            a.setFilename(og.getFilename());
            a.setFilepath(og.getFilepath());

            //@FIXME edit this to include fileContents
        }
        return dao.update(a);
    }
}
