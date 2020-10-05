package com.xgen.output.types.outputtofile.plaintxt;

import com.xgen.output.types.outputtofile.AbstractFactory;
import com.xgen.output.types.outputtofile.GenOutPathPackages;
import com.xgen.output.types.outputtofile.Outter;

public class PlainTxtFactory implements AbstractFactory {
    @Override
    public GenOutPathPackages createGenOutPathPackages() {
        return new GenOutPathPackageImpl();
    }

    @Override
    public Outter createOutter() {
        return new OutterImpl();
    }
}
