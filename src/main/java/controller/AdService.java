package controller;

import model.dao.AdDAO;
import model.entity.Ad;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static Ad editAd(Ad a, String sTarg)
    {
        Ad og = dao.read(a.getID());

        String hardcode = "/Users/emmasmith/IdeaProjects/software-engineering-project/src/main/webapp/adimages/";

        if(a.getFilename().isEmpty())
        {
            a.setFilename(og.getFilename());
            a.setFilepath(og.getFilepath());
        }
        else
        {
            a.setFilepath(hardcode + a.getFilename());
        }

        Path o = Paths.get(og.getFilepath());
        Path n = Paths.get(a.getFilepath());

        Path oTarg = Path.of(sTarg, og.getFilename());
        Path nTarg = Path.of(sTarg, a.getFilename());

        try
        {
            Files.move(o, n);
            Files.move(oTarg, nTarg);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return dao.update(a);
    }

    public static Ad getAd(int id)
    {
        return dao.read(id);
    }
}
