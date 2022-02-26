package dev.toliner.hoi4lspkt

import org.eclipse.lsp4j.launch.LSPLauncher

fun main() {
    val server = HoI4LanguageServer()
    val launcher = LSPLauncher.createServerLauncher(server, System.`in`, System.out)
    val client = launcher.remoteProxy

    server.connect(client)
    launcher.startListening()
}
