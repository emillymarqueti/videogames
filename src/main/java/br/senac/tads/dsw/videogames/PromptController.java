package br.senac.tads.dsw.videogames;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptController {

	private static final String INFO_CRIACAO = "2026-11-24 21:10 - Google Gemini";

	@GetMapping(value = "/prompt", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	public ResponseEntity<String> obterPrompt() throws IOException {
		Path caminho = Path.of("PROMPT.md");
		if (!Files.exists(caminho)) {
			return ResponseEntity.ok(INFO_CRIACAO);
		}
		String conteudo = Files.readString(caminho, StandardCharsets.UTF_8);
		return ResponseEntity.ok(conteudo);
	}
}