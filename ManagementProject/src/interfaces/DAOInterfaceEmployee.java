package interfaces;

import java.util.ArrayList;

public interface DAOInterfaceEmployee<EntityType, KeyType> {

	public int Insert(EntityType E);

	public int Update(EntityType E);

	public int Delete(KeyType K);

	public ArrayList<EntityType> SelectALl();

	public ArrayList<EntityType> FindById(KeyType K);

	public ArrayList<EntityType> SelectBySql(String sql, Object... args);

}
