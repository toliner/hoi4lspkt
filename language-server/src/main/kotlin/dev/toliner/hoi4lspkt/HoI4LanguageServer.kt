package dev.toliner.hoi4lspkt

import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.services.*
import java.util.concurrent.CompletableFuture
import java.util.logging.Logger

class HoI4LanguageServer: LanguageServer, LanguageClientAware {
    private lateinit var client: LanguageClient
    private val logger = Logger.getLogger(this::class.simpleName)

    override fun initialize(params: InitializeParams): CompletableFuture<InitializeResult> {
        val capabilities = ServerCapabilities().apply {
            setTextDocumentSync(TextDocumentSyncKind.Full)
        }
        val completionOptions = CompletionOptions().apply {
            resolveProvider = true
        }

        capabilities.completionProvider = completionOptions
        val result = InitializeResult(capabilities)
        return CompletableFuture.completedFuture(result)
    }

    override fun initialized(params: InitializedParams) {
        client.logMessage(MessageParams(MessageType.Info, "HoI4LSP.kt is Initialized!"))
    }

    override fun shutdown(): CompletableFuture<Any> {
        TODO("Not yet implemented")
    }

    override fun exit() {
        TODO("Not yet implemented")
    }

    override fun getTextDocumentService(): TextDocumentService {
        return HoI4TextDocumentService(client)
    }

    override fun getWorkspaceService(): WorkspaceService {
        TODO("Not yet implemented")
    }

    override fun connect(client: LanguageClient) {
        this.client = client
    }
}