package com.themes.simple.actions;


import com.xgen.genconf.vo.ModuleConfModel;
import com.xgen.geninvocation.BaseGenAction;

public class GenBusinessEbiAction extends BaseGenAction {

	@Override
	public Object initObject() {
		return "";
	}

	@Override
	public Object execute(ModuleConfModel moduleConf, Object obj) {
		//需要完成的工作并不固定
		//1：读取相应的模板文件
		//2：分解模板文件里面需要替换的属性，从moduleConf里面取值替换过去
		//3：分解模板文件里面需要执行的方法，这个并不一定是每个功能都需要的
		return obj;
	}


	
}