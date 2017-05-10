package com.atslangplugin

import com.atslangplugin.parser.ATSParser
import com.atslangplugin.psi.ATSFile
import com.atslangplugin.psi.ATSTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import java.io.Reader

class ATSParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer {
        return FlexAdapter(ATSLexer(null as Reader?))
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }

    override fun getCommentTokens(): TokenSet {
        return COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createParser(project: Project): PsiParser {
        return ATSParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return ATSFile(viewProvider)
    }

    override fun spaceExistanceTypeBetweenTokens(
            Left: ASTNode, Right: ASTNode
    ): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun createElement(node: ASTNode): PsiElement {
        return ATSTypes.Factory.createElement(node)
    }

    companion object {
        val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
        val COMMENTS = TokenSet.create(ATSTypes.COMMENT)

        val FILE = IFileElementType(
                Language.findInstance(ATSLanguage::class.java)
        )
    }


}
