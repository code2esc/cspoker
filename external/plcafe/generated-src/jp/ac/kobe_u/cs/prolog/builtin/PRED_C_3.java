package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'C'/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
public class PRED_C_3 extends Predicate {

    public Term arg1, arg2, arg3;

    public PRED_C_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_C_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "C(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
    // 'C'([A|B],A,B):-true
        engine.setB0();
        Term a1, a2, a3, a4, a5;
        a1 = arg1;
        a2 = arg2;
        a3 = arg3;
    // 'C'([A|B],A,B):-[]
        a1 = a1.dereference();
        if (a1.isList()){
            Term[] args = {((ListTerm)a1).car(), ((ListTerm)a1).cdr()};
            a4 = args[0];
            a5 = args[1];
        } else if (a1.isVariable()){
            a4 = new VariableTerm(engine);
            a5 = new VariableTerm(engine);
            ((VariableTerm) a1).bind(new ListTerm(a4, a5), engine.trail);
        } else {
            return engine.fail();
        }
        if (! a4.unify(a2, engine.trail))
            return engine.fail();
        if (! a5.unify(a3, engine.trail))
            return engine.fail();
        return cont;
    }
}