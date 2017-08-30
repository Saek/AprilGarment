package com.testspring.daos;

import java.util.List;
import com.testspring.models.Factory;

public interface FactoryDAO {
	public List<Factory> showFactories();
	public List<Factory> getFactoriesForDropDownList();
	public Factory getFactoryById(int factoryId);
}
