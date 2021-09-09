package biz;

import java.util.List;

import dao.NStoreAddressDaoImpl;
import entity.StoreAddress;

public class NStoreAddressBizImpl implements NStoreAddressBiz {

	@Override
	public List<StoreAddress> getStoreAddress() {
		// TODO Auto-generated method stub
		return new NStoreAddressDaoImpl().getStoreAddress();
	}

}
