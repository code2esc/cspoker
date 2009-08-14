package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>hash_map/3</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_hash_map_3 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol("[]");
    static SymbolTerm s2 = SymbolTerm.makeSymbol(",", 2);
    static Predicate _fail_0 = new PRED_fail_0();
    static Predicate _hash_map_3_var = new PRED_hash_map_3_var();
    static Predicate _hash_map_3_var_1 = new PRED_hash_map_3_var_1();
    static Predicate _hash_map_3_1 = new PRED_hash_map_3_1();
    static Predicate _hash_map_3_2 = new PRED_hash_map_3_2();

    public Term arg1, arg2, arg3;

    public PRED_hash_map_3(Term a1, Term a2, Term a3, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        arg3 = a3;
        this.cont = cont;
    }

    public PRED_hash_map_3(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        arg3 = args[2];
        this.cont = cont;
    }

    public int arity() { return 3; }

    public String toString() {
        return "hash_map(" + arg1 + "," + arg2 + "," + arg3 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.aregs[3] = arg3;
        engine.cont = cont;
        engine.setB0();
        return engine.switch_on_term(_hash_map_3_var, _fail_0, _fail_0, _hash_map_3_1, _fail_0, _hash_map_3_2);
    }
}

class PRED_hash_map_3_var extends PRED_hash_map_3 {
    public Predicate exec(Prolog engine) {
        return engine.jtry(_hash_map_3_1, _hash_map_3_var_1);
    }
}

class PRED_hash_map_3_var_1 extends PRED_hash_map_3 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_hash_map_3_2);
    }
}

class PRED_hash_map_3_1 extends PRED_hash_map_3 {
    public Predicate exec(Prolog engine) {
    // hash_map([],[],A):-!
        Term a1, a2, a3;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // hash_map([],[],A):-['$neck_cut']
        a1 = a1.dereference();
        if (a1.isSymbol()){
            if (! a1.equals(s1))
                return engine.fail();
        } else if (a1.isVariable()){
            ((VariableTerm) a1).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        a2 = a2.dereference();
        if (a2.isSymbol()){
            if (! a2.equals(s1))
                return engine.fail();
        } else if (a2.isVariable()){
            ((VariableTerm) a2).bind(s1, engine.trail);
        } else {
            return engine.fail();
        }
        //START inline expansion of $neck_cut
        engine.neckCut();
        //END inline expansion
        return cont;
    }
}

class PRED_hash_map_3_2 extends PRED_hash_map_3 {
    public Predicate exec(Prolog engine) {
    // hash_map([A|B],[(A,C)|D],E):-hash_get(E,A,C),hash_map(B,D,E)
        Term a1, a2, a3, a4, a5, a6, a7, a8;
        Predicate p1;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        a3 = engine.aregs[3];
        cont = engine.cont;
    // hash_map([A|B],[(A,C)|D],E):-[hash_get(E,A,C),hash_map(B,D,E)]
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
        a2 = a2.dereference();
        if (a2.isList()){
            Term[] args = {((ListTerm)a2).car(), ((ListTerm)a2).cdr()};
            a6 = args[0];
            a7 = args[1];
        } else if (a2.isVariable()){
            a6 = new VariableTerm(engine);
            a7 = new VariableTerm(engine);
            ((VariableTerm) a2).bind(new ListTerm(a6, a7), engine.trail);
        } else {
            return engine.fail();
        }
        a6 = a6.dereference();
        if (a6.isStructure()){
            if (! s2.equals(((StructureTerm)a6).functor()))
                return engine.fail();
            Term[] args = ((StructureTerm)a6).args();
            if (! a4.unify(args[0], engine.trail))
                return engine.fail();
            a8 = args[1];
        } else if (a6.isVariable()){
            a8 = new VariableTerm(engine);
            Term[] args = {a4, a8};
            ((VariableTerm) a6).bind(new StructureTerm(s2, args), engine.trail);
        } else {
            return engine.fail();
        }
        p1 = new PRED_hash_map_3(a5, a7, a3, cont);
        return new PRED_hash_get_3(a3, a4, a8, p1);
    }
}