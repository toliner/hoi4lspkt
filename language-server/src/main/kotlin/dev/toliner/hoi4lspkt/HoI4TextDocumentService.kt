package dev.toliner.hoi4lspkt

import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.services.LanguageClient
import org.eclipse.lsp4j.services.TextDocumentService
import java.net.URI

class HoI4TextDocumentService(private val client: LanguageClient): TextDocumentService {
    private val diagnostic: Map<URI, List<Diagnostic>> = mutableMapOf()

    override fun didOpen(params: DidOpenTextDocumentParams) {

    }

    override fun didChange(params: DidChangeTextDocumentParams) {
        TODO("Not yet implemented")
    }

    override fun didClose(params: DidCloseTextDocumentParams) {
        client.publishDiagnostics(PublishDiagnosticsParams(params.textDocument.uri, emptyList()))
    }

    override fun didSave(params: DidSaveTextDocumentParams) {
        TODO("Not yet implemented")
    }
}