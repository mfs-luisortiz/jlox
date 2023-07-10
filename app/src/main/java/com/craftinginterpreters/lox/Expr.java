package com.craftinginterpreters.lox;

import java.util.List;

abstract class Expr {
  interface Visitor<E> {
    E visitBinaryExpr(Binary expr);
    E visitGroupingExpr(Grouping expr);
    E visitLiteralExpr(Literal expr);
    E visitUnaryExpr(Unary expr);
  }
  static class Binary extends Expr {
    Binary(Expr left, Token operator, Expr right) {
      this.left = left;
      this.operator = operator;
      this.right = right;
    }

    @Override
    <E> E accept(Visitor<E> visitor) {
      return visitor.visitBinaryExpr(this);
    }

    final Expr left;
    final Token operator;
    final Expr right;
  }
  static class Grouping extends Expr {
    Grouping(Expr expression) {
      this.expression = expression;
    }

    @Override
    <E> E accept(Visitor<E> visitor) {
      return visitor.visitGroupingExpr(this);
    }

    final Expr expression;
  }
  static class Literal extends Expr {
    Literal(Object value) {
      this.value = value;
    }

    @Override
    <E> E accept(Visitor<E> visitor) {
      return visitor.visitLiteralExpr(this);
    }

    final Object value;
  }
  static class Unary extends Expr {
    Unary(Token operator, Expr right) {
      this.operator = operator;
      this.right = right;
    }

    @Override
    <E> E accept(Visitor<E> visitor) {
      return visitor.visitUnaryExpr(this);
    }

    final Token operator;
    final Expr right;
  }

  abstract <E> E accept(Visitor<E> visitor);
}
