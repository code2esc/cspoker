package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$on_exception'/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$on_exception_3 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("$no_ball");
    static SymbolTerm s2 = SymbolTerm.makeSymbol(":", 2);
    static SymbolTerm s3 = SymbolTerm.makeSymbol("jp.ac.kobe_u.cs.prolog.builtin");
    static Predicate _$on_exception_3_sub_1 = new PRED_$on_exception_3_sub_1();
    static Predicate _$on_exception_3_1 = new PRED_$on_exception_3_1();
    static Predicate _$on_exception_3_2 = new PRED_$on_exception_3_2();

    public Term arg1, arg2, arg3;

    public PRED_$on_exception_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_$on_exception_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "$on_exception(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$on_exception_3_1, _$on_exception_3_sub_1);
    }
}

class PRED_$on_exception_3_sub_1 extends PRED_$on_exception_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$on_exception_3_2);
    }
}

class PRED_$on_exception_3_1 extends PRED_$on_exception_3 {
    public Predicate exec(Prolog engine) {
    // '$on_exception'(A,B,C):-'$set_exception'('$no_ball'),'$begin_exception'(D),call(B),'$end_exception'(D)
        Term a1, a2, a3, a4, a5;
        Predicate p1, p2, p3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$on_exception'(A,B,C):-['$set_exception'('$no_ball'),'$begin_exception'(D),call('jp.ac.kobe_u.cs.prolog.builtin':B),'$end_exception'(D)]
        a4 = new VariableTerm(engine);
        Term[] y1 = {s3, a2};
        a5 = new StructureTerm(s2, y1);
        p1 = new PRED_$end_exception_1(a4, cont);
        p2 = new PRED_call_1(a5, p1);
        p3 = new PRED_$begin_exception_1(a4, p2);
        return new PRED_$set_exception_1(s1, p3);
    }
}

class PRED_$on_exception_3_2 extends PRED_$on_exception_3 {
    public Predicate exec(Prolog engine) {
    // '$on_exception'(A,B,C):-'$get_exception'(D),D\=='$no_ball','$catch_and_throw'(D,A,C)
        Term a1, a2, a3, a4;
        Predicate p1, p2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // '$on_exception'(A,B,C):-['$get_exception'(D),'$inequality_of_term'(D,'$no_ball'),'$catch_and_throw'(D,A,C)]
        a4 = new VariableTerm(engine);
        p1 = new PRED_$catch_and_throw_3(a4, a1, a3, cont);
        p2 = new PRED_$inequality_of_term_2(a4, s1, p1);
        return new PRED_$get_exception_1(a4, p2);
    }
}