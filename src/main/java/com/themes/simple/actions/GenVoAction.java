package com.themes.simple.actions;


import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.geninvocation.BaseGenAction;
import com.xgen.geninvocation.decorator.GenComponent;

public class GenVoAction extends BaseGenAction {
	
	@Override
	public Object executeDecorators(ModuleConfModel moduleConf, Object obj,
									GenComponent gc) {
		return gc.operation(moduleConf, "GenVo", obj);
	}

	@Override
	public Object initObject() {
		return "";
	}

	@Override
	public Object execute(ModuleConfModel moduleConf, Object obj) {
		return obj;
	}
	
	public  GenComponent beforeAction(ModuleConfModel moduleConf){
		return super.defaultBeforeAction(moduleConf);
	}
}

