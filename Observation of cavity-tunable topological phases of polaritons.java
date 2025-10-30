/*
 * SSH_model_in_a_cavity_unitcell_scan_ly_to_github_2.java
 */

import com.comsol.model.*;
import com.comsol.model.util.*;

/** Model exported on Apr 1 2025, 15:38 by COMSOL 6.2.0.339. */
public class SSH_model_in_a_cavity_unitcell_scan_ly_to_github_2 {

  public static Model run() {
    Model model = ModelUtil.create("Model");

    model.modelPath("E:\\Comsol mode\\SSH mode in a cavity\\20221006");

    model.label("SSH mode in a Cavity  unitcell scan ly to github .mph");

    model.param().set("a", "22[mm]");
    model.param().set("d", "40[mm]");
    model.param().set("d1", "0.575*d");
    model.param().set("R", "6.5[mm]");
    model.param().set("r", "1[mm]");
    model.param().set("n", "4");
    model.param().set("kx", "0");
    model.param().set("ky", "0");
    model.param().set("hh", "20[mm]");
    model.param().set("L", "0.6*d");
    model.param().set("ly", "3*d");
    model.param().set("d2", "d-d1");

    model.component().create("comp1", true);

    model.component("comp1").geom().create("geom1", 3);

    model.component("comp1").func().create("pw1", "Piecewise");
    model.component("comp1").func("pw1").set("arg", "kx");
    model.component("comp1").func("pw1").set("pieces", new String[][]{{"0", "pi/d", "c_const*kx/(2*pi)"}});

    model.component("comp1").mesh().create("mesh1");

    model.component("comp1").geom("geom1").autoBuildNew(true);
    model.component("comp1").geom("geom1").autoRebuild("on");
    model.component("comp1").geom("geom1").create("hel1", "Helix");
    model.component("comp1").geom("geom1").feature("hel1").set("pos", new String[]{"-0.5*d1", "0", "0"});
    model.component("comp1").geom("geom1").feature("hel1").set("turns", "n");
    model.component("comp1").geom("geom1").feature("hel1").set("rmaj", "R");
    model.component("comp1").geom("geom1").feature("hel1").set("rmin", "r");
    model.component("comp1").geom("geom1").feature("hel1").set("axialpitch", "hh/n");
    model.component("comp1").geom("geom1").create("hel2", "Helix");
    model.component("comp1").geom("geom1").feature("hel2").set("pos", new String[]{"0.5*d1", "0", "0"});
    model.component("comp1").geom("geom1").feature("hel2").set("turns", "n");
    model.component("comp1").geom("geom1").feature("hel2").set("rmaj", "R");
    model.component("comp1").geom("geom1").feature("hel2").set("rmin", "r");
    model.component("comp1").geom("geom1").feature("hel2").set("axialpitch", "hh/n");
    model.component("comp1").geom("geom1").create("wp1", "WorkPlane");
    model.component("comp1").geom("geom1").feature("wp1").active(false);
    model.component("comp1").geom("geom1").feature("wp1").set("quickplane", "zx");
    model.component("comp1").geom("geom1").feature("wp1").set("unite", true);
    model.component("comp1").geom("geom1").feature("wp1").geom().create("r1", "Rectangle");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1").set("base", "center");
    model.component("comp1").geom("geom1").feature("wp1").geom().feature("r1").set("size", new String[]{"d", "3*L"});
    model.component("comp1").geom("geom1").create("blk1", "Block");
    model.component("comp1").geom("geom1").feature("blk1").set("pos", new String[]{"0", "0", "hh/2"});
    model.component("comp1").geom("geom1").feature("blk1").set("base", "center");
    model.component("comp1").geom("geom1").feature("blk1").set("size", new String[]{"d", "ly", "L"});
    model.component("comp1").geom("geom1").create("dif1", "Difference");
    model.component("comp1").geom("geom1").feature("dif1").selection("input").set("blk1");
    model.component("comp1").geom("geom1").feature("dif1").selection("input2").set("hel1(1)", "hel2(1)");
    model.component("comp1").geom("geom1").run();

    model.component("comp1").physics().create("emw", "ElectromagneticWaves", "geom1");
    model.component("comp1").physics("emw").create("pc1", "PeriodicCondition", 2);
    model.component("comp1").physics("emw").feature("pc1").selection().set(1, 18);
    model.component("comp1").physics("emw").create("sctr1", "Scattering", 2);
    model.component("comp1").physics("emw").feature("sctr1").selection().set(3, 4);

    model.component("comp1").mesh("mesh1").create("ftri1", "FreeTri");
    model.component("comp1").mesh("mesh1").create("copy1", "Copy");
    model.component("comp1").mesh("mesh1").create("ftet1", "FreeTet");
    model.component("comp1").mesh("mesh1").feature("ftri1").selection().set(18);
    model.component("comp1").mesh("mesh1").feature("ftri1").create("size1", "Size");
    model.component("comp1").mesh("mesh1").feature("ftet1").create("size1", "Size");
    model.component("comp1").mesh("mesh1").feature("ftet1").create("cr1", "CornerRefinement");

    model.component("comp1").view("view1").set("showgrid", false);
    model.component("comp1").view("view1").set("scenelight", false);
    model.component("comp1").view("view1").set("transparency", true);
    model.component("comp1").view("view1").set("uniformblending", true);
    model.component("comp1").view("view2").axis().set("xmin", -0.10304966568946838);
    model.component("comp1").view("view2").axis().set("xmax", 0.10304966568946838);
    model.component("comp1").view("view2").axis().set("ymin", -0.07559999823570251);
    model.component("comp1").view("view2").axis().set("ymax", 0.07559999823570251);

    model.component("comp1").physics("emw").prop("PortOptions").set("PortFormulation", "ConstraintBased");
    model.component("comp1").physics("emw").feature("wee1").set("epsilonr_mat", "userdef");
    model.component("comp1").physics("emw").feature("wee1").set("epsilonInf_mat", "from_mat");
    model.component("comp1").physics("emw").feature("wee1").set("mur_mat", "userdef");
    model.component("comp1").physics("emw").feature("wee1").set("sigma_mat", "userdef");
    model.component("comp1").physics("emw").feature("pc1").set("PeriodicType", "Floquet");
    model.component("comp1").physics("emw").feature("pc1")
         .set("kFloquet", new String[][]{{"kx*pi/d"}, {"0"}, {"0"}});
    model.component("comp1").physics("emw").feature("sctr1").active(false);

    model.component("comp1").mesh("mesh1").feature("size").set("hauto", 1);
    model.component("comp1").mesh("mesh1").feature("size").set("custom", "on");
    model.component("comp1").mesh("mesh1").feature("size").set("hmax", 0.004);
    model.component("comp1").mesh("mesh1").feature("size").set("hmin", "2E-5");
    model.component("comp1").mesh("mesh1").feature("size").set("hgrad", 1.45);
    model.component("comp1").mesh("mesh1").feature("ftri1").feature("size1").set("hauto", 1);
    model.component("comp1").mesh("mesh1").feature("ftri1").feature("size1").set("custom", "on");
    model.component("comp1").mesh("mesh1").feature("ftri1").feature("size1").set("hmax", 0.0012);
    model.component("comp1").mesh("mesh1").feature("ftri1").feature("size1").set("hmaxactive", true);
    model.component("comp1").mesh("mesh1").feature("copy1").set("dimension", 2);
    model.component("comp1").mesh("mesh1").feature("copy1").selection("source").set(18);
    model.component("comp1").mesh("mesh1").feature("copy1").selection("destination").set(1);
    model.component("comp1").mesh("mesh1").feature("ftet1").feature("size1").set("hauto", 4);
    model.component("comp1").mesh("mesh1").feature("ftet1").feature("size1").set("custom", "on");
    model.component("comp1").mesh("mesh1").feature("ftet1").feature("size1").set("hmaxactive", true);
    model.component("comp1").mesh("mesh1").feature("ftet1").feature("size1").set("hmin", 0.001);
    model.component("comp1").mesh("mesh1").feature("ftet1").feature("size1").set("hminactive", true);
    model.component("comp1").mesh("mesh1").run();

    model.study().create("std1");
    model.study("std1").create("param", "Parametric");
    model.study("std1").create("eig", "Eigenfrequency");

    model.externalInterface().create("sim1", "SimulinkCosimulation");

    model.result().create("pg1", "PlotGroup1D");
    model.result("pg1").create("glob1", "Global");

    model.study("std1").feature("param").set("pname", new String[]{"kx"});
    model.study("std1").feature("param").set("plistarr", new String[]{"range(-1,1/20,1)"});
    model.study("std1").feature("param").set("punit", new String[]{""});
    model.study("std1").feature("eig").set("neigs", 11);
    model.study("std1").feature("eig").set("neigsactive", true);
    model.study("std1").feature("eig").set("shift", "0.6[GHz]");
    model.study("std1").feature("eig").set("eigwhich", "lr");

    model.result("pg1").feature("glob1").set("linewidth", "preference");

    return model;
  }

  public static void main(String[] args) {
    run();
  }

}
