// This is a generated file. Not intended for manual editing.
package com.atslangplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.atslangplugin.psi.ATSTokenTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.atslangplugin.psi.*;

public class ATSPropertyImpl extends ASTWrapperPsiElement implements ATSProperty {

  public ATSPropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ATSVisitor visitor) {
    visitor.visitProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ATSVisitor) accept((ATSVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ATSKey getKey() {
    return findChildByClass(ATSKey.class);
  }

}
