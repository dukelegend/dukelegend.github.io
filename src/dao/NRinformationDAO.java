package dao;

import java.util.List;

import entity.Rinformation;

public interface NRinformationDAO {
	List<Rinformation> getRinformation(String cid);

}
