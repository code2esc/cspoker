package jp.ac.kobe_u.cs.prolog.builtin;
import jp.ac.kobe_u.cs.prolog.lang.*;
/*
 This file is generated by Prolog Cafe.
 PLEASE DO NOT EDIT!
*/
/**
 <code>'$parse_tokens_skip_spaces'/2</code> defined in builtins.pl<br>
 @author Mutsunori Banbara (banbara@kobe-u.ac.jp)
 @author Naoyuki Tamura (tamura@kobe-u.ac.jp)
 @version 1.0
*/
class PRED_$parse_tokens_skip_spaces_2 extends Predicate {
    static SymbolTerm s1 = SymbolTerm.makeSymbol(" ");
    static Predicate _$parse_tokens_skip_spaces_2_sub_1 = new PRED_$parse_tokens_skip_spaces_2_sub_1();
    static Predicate _$parse_tokens_skip_spaces_2_1 = new PRED_$parse_tokens_skip_spaces_2_1();
    static Predicate _$parse_tokens_skip_spaces_2_2 = new PRED_$parse_tokens_skip_spaces_2_2();

    public Term arg1, arg2;

    public PRED_$parse_tokens_skip_spaces_2(Term a1, Term a2, Predicate cont) {
        arg1 = a1;
        arg2 = a2;
        this.cont = cont;
    }

    public PRED_$parse_tokens_skip_spaces_2(){}

    public void setArgument(Term[] args, Predicate cont) {
        arg1 = args[0];
        arg2 = args[1];
        this.cont = cont;
    }

    public int arity() { return 2; }

    public String toString() {
        return "$parse_tokens_skip_spaces(" + arg1 + "," + arg2 + ")";
    }

    public Predicate exec(Prolog engine) {
        engine.aregs[1] = arg1;
        engine.aregs[2] = arg2;
        engine.cont = cont;
        engine.setB0();
        return engine.jtry(_$parse_tokens_skip_spaces_2_1, _$parse_tokens_skip_spaces_2_sub_1);
    }
}

class PRED_$parse_tokens_skip_spaces_2_sub_1 extends PRED_$parse_tokens_skip_spaces_2 {
    public Predicate exec(Prolog engine) {
        return engine.trust(_$parse_tokens_skip_spaces_2_2);
    }
}

class PRED_$parse_tokens_skip_spaces_2_1 extends PRED_$parse_tokens_skip_spaces_2 {
    public Predicate exec(Prolog engine) {
    // '$parse_tokens_skip_spaces'(A,B):-'C'(A,' ',C),!,'$parse_tokens_skip_spaces'(C,B)
        Term a1, a2, a3, a4;
        Predicate p1, p2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$parse_tokens_skip_spaces'(A,B):-['$get_level'(C),'C'(A,' ',D),'$cut'(C),'$parse_tokens_skip_spaces'(D,B)]
        a3 = new VariableTerm(engine);
        //START inline expansion of $get_level(a(3))
        if (! a3.unify(new IntegerTerm(engine.B0), engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        a4 = new VariableTerm(engine);
        p1 = new PRED_$parse_tokens_skip_spaces_2(a4, a2, cont);
        p2 = new PRED_$cut_1(a3, p1);
        return new PRED_C_3(a1, s1, a4, p2);
    }
}

class PRED_$parse_tokens_skip_spaces_2_2 extends PRED_$parse_tokens_skip_spaces_2 {
    public Predicate exec(Prolog engine) {
    // '$parse_tokens_skip_spaces'(A,B):-B=A
        Term a1, a2;
        Predicate cont;
        a1 = engine.aregs[1];
        a2 = engine.aregs[2];
        cont = engine.cont;
    // '$parse_tokens_skip_spaces'(A,B):-['$unify'(B,A)]
        //START inline expansion of $unify(a(2),a(1))
        if (! a2.unify(a1, engine.trail)) {
            return engine.fail();
        }
        //END inline expansion
        return cont;
    }
}