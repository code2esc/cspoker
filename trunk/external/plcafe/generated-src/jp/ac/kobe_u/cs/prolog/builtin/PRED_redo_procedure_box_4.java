package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>redo_procedure_box/4</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_redo_procedure_box_4 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("redo");
    static Predicate _redo_procedure_box_4_sub_1 = new PRED_redo_procedure_box_4_sub_1();
    static Predicate _redo_procedure_box_4_1 = new PRED_redo_procedure_box_4_1();
    static Predicate _redo_procedure_box_4_2 = new PRED_redo_procedure_box_4_2();

    public Term arg1, arg2, arg3, arg4;

    public PRED_redo_procedure_box_4(Term a1, Term a2, Term a3, Term a4, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        arg4 = a4;
        this.cont = cont;
    }

    public PRED_redo_procedure_box_4(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        arg4 = args[3];
        this.cont = cont;
    }

    public int arity() { return 4; }

    public String toString() {
        return "redo_procedure_box(" + arg1 + "," + arg2 + "," + arg3 + "," + arg4 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.aregs[4] = arg4;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_redo_procedure_box_4_1, _redo_procedure_box_4_sub_1);
    }
}

class PRED_redo_procedure_box_4_sub_1 extends PRED_redo_procedure_box_4 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_redo_procedure_box_4_2);
    }
}

class PRED_redo_procedure_box_4_1 extends PRED_redo_procedure_box_4 {
    public Predicate exec(Prolog engine) {
    // redo_procedure_box(A,B,C,D):-true
        Term a1, a2, a3, a4;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        cont = engine.cont;
    // redo_procedure_box(A,B,C,D):-[]
        return cont;
    }
}

class PRED_redo_procedure_box_4_2 extends PRED_redo_procedure_box_4 {
    public Predicate exec(Prolog engine) {
    // redo_procedure_box(A,B,C,D):-print_procedure_box(redo,A,B,C,D),fail
        Term a1, a2, a3, a4;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        a4 = engine.aregs[4];
        cont = engine.cont;
    // redo_procedure_box(A,B,C,D):-[print_procedure_box(redo,A,B,C,D),fail]
        p1 = new PRED_fail_0(cont);
        return new PRED_print_procedure_box_5(s1, a1, a2, a3, a4, p1);
    }
}