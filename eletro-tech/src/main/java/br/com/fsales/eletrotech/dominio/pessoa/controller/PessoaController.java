package br.com.fsales.eletrotech.dominio.pessoa.controller;

import br.com.fsales.eletrotech.dominio.pessoa.controller.openapi.Swagger;
import br.com.fsales.eletrotech.dominio.pessoa.dto.DadosAtualizarPessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.dto.ListarPessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.dto.PessoaRequest;
import br.com.fsales.eletrotech.dominio.pessoa.dto.PessoaResponse;
import br.com.fsales.eletrotech.dominio.pessoa.service.PessoaService;
import br.com.fsales.eletrotech.infrastructure.exception.dto.Violation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@Tag(
        name = Swagger.API_PESSOA_TAG_NAME,
        description = Swagger.API_PESSOA_TAG_DESCRIPTION
)

@RestController
@RequestMapping("pessoas")
@RequiredArgsConstructor

@Validated

@Slf4j
public class PessoaController {

    private final PessoaService pessoaService;

    /**
     * @param pageable
     * @param request
     * @return
     */
    @Operation(
            summary = Swagger.API_PESSOA_OPERATION_SUMMARY_LISTAR_PESSOA,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro encontrado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PessoaResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "204",
                            description = "Registro não encontrado",
                            content = @Content(
                                    mediaType = "*/*"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Bad Request",
                            content = @Content(
                                    mediaType = "*/*",
                                    schema = @Schema(implementation = Violation.class)
                            )
                    )
            }
    )
    @PageableAsQueryParam
    @GetMapping
    public ResponseEntity<Page<PessoaResponse>> listarTodos(
            @Parameter(hidden = true) @PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable pageable,
            ListarPessoaRequest request
    ) {
        var pessoaPageable = pessoaService.consultaPaginada(
                request,
                pageable
        );

        return ResponseEntity.ok(
                pessoaPageable
                        .map(PessoaDtoMapper::fromPessoaToResponse)
        );
    }

    /**
     * @param request
     * @param uriComponentsBuilder
     * @return
     */
    @Operation(
            summary = Swagger.API_PESSOA_OPERATION_SUMMARY_CRIAR_PESSOA,

            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Registro criado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PessoaResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Bad Request",
                            content = @Content(
                                    mediaType = "*/*",
                                    schema = @Schema(implementation = Violation.class)
                            )
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = PessoaRequest.class))
            )
    )
    @PostMapping
    public ResponseEntity<PessoaResponse> cadastrar(
            @Valid
            @RequestBody
            PessoaRequest request,
            UriComponentsBuilder uriComponentsBuilder
    ) {

        var pessoa = pessoaService.save(
                request
        );

        log.debug(
                "Dados request: {}",
                request.toString()
        );

        var uri = uriComponentsBuilder
                .path("/pessoas/{id}")
                .buildAndExpand(
                        pessoa.getId()
                )
                .toUri();

        return ResponseEntity
                .created(uri)
                .body(
                        PessoaDtoMapper.fromPessoaToResponse(pessoa)
                );
    }

    /**
     * @param id
     * @return
     */
    @Operation(
            summary = Swagger.API_PESSOA_OPERATION_SUMMARY_DETALHAR_PESSOA,

            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro encontrado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PessoaResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Bad Request",
                            content = @Content(
                                    mediaType = "*/*",
                                    schema = @Schema(implementation = Violation.class)
                            )
                    )
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> detalhar(
            @PathVariable UUID id
    ) {
        var pessoa = pessoaService
                .detalhar(id);

        return ResponseEntity.ok(
                PessoaDtoMapper.fromPessoaToResponse(pessoa)
        );
    }

    /**
     * @param id
     * @return
     */
    @Operation(
            summary = Swagger.API_PESSOA_OPERATION_SUMMARY_EXCLUIR_PESSOA,
            parameters = {
                    @Parameter(
                            schema = @Schema(implementation = UUID.class)
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Registro excluído",
                            content = @Content(
                                    mediaType = "*/*"
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Bad Request",
                            content = @Content(
                                    mediaType = "*/*",
                                    schema = @Schema(implementation = Violation.class)
                            )
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id
    ) {
        pessoaService
                .excluir(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @Operation(
            summary = Swagger.API_PESSOA_OPERATION_SUMMARY_ATUALIZAR_PESSOA,

            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro atualizado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PessoaResponse.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Bad Request",
                            content = @Content(
                                    mediaType = "*/*",
                                    schema = @Schema(implementation = Violation.class)
                            )
                    )
            },
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(schema = @Schema(implementation = DadosAtualizarPessoaRequest.class))
            )
    )
    @PutMapping
    public ResponseEntity<PessoaResponse> atualizar(
            @Valid
            @RequestBody
            DadosAtualizarPessoaRequest request
    ) {

        var pessoa = pessoaService
                .atualizar(
                        request
                );

        return ResponseEntity.ok(
                PessoaDtoMapper.fromPessoaToResponse(pessoa)
        );
    }
}
