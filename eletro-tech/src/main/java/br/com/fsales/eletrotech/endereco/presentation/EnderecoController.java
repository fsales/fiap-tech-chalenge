package br.com.fsales.eletrotech.endereco.presentation;


import br.com.fsales.eletrotech.endereco.application.service.EnderecoService;
import br.com.fsales.eletrotech.endereco.presentation.dto.*;
import br.com.fsales.eletrotech.endereco.presentation.openapi.Swagger;
import br.com.fsales.eletrotech.endereco.presentation.util.EnderecoCustomerMapper;
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
        name = Swagger.API_ENDERECO_TAG_NAME,
        description = Swagger.API_ENDERECO_TAG_DESCRIPTION
)

@RestController
@RequestMapping("enderecos")
@RequiredArgsConstructor

@Validated

@Slf4j
public class EnderecoController {

    private final EnderecoService enderecoService;

    private final EnderecoCustomerMapper enderecoCustomMapper;

    /**
     * @param request
     * @param pageable
     * @return
     */
    @Operation(
            summary = Swagger.API_ENDERECO_OPERATION_SUMMARY_LISTAR_ENDERECO,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro encontrado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EnderecoResponse.class)
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
    public ResponseEntity<Page<ListarEnderecoResponse>> listar(
            ListarEnderecoRequest request,
            @Parameter(hidden = true) @PageableDefault(page = 0, size = 10) Pageable pageable
    ) {

        var enderecoPage = enderecoService.consultaPaginada(
                enderecoCustomMapper.listarEnderecoRequestToFiltroEnderecoListar(request),
                pageable
        );

        return ResponseEntity.ok(
                enderecoPage.map(enderecoCustomMapper::enderecoListarToListarEnderecoResponse)
        );
    }

    @Operation(
            summary = Swagger.API_ENDERECO_OPERATION_SUMMARY_CRIAR_ENDERECO,

            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Registro criado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EnderecoResponse.class)
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
                    content = @Content(schema = @Schema(implementation = EnderecoRequest.class))
            )
    )
    @PostMapping
    public ResponseEntity<EnderecoResponse> cadastrar(
            @Valid @RequestBody EnderecoRequest request,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        log.debug(
                "Dados request: {}",
                request.toString()
        );

        var endereco = enderecoService.cadastrar(
                enderecoCustomMapper.enderecoRequestToEnderecoCadastro(
                        request
                )
        );


        var uri = uriComponentsBuilder.path(
                "/enderecos/{id}"
        ).buildAndExpand(
                String.format(
                        "%s/pessoa/%s",
                        endereco.id(),
                        endereco.idPessoa()
                )

        ).toUri();

        return ResponseEntity
                .created(
                        uri
                ).body(
                        EnderecoResponse.fromEnderecoToResponse(endereco)
                );
    }

    @Operation(
            summary = Swagger.API_ENDERECO_OPERATION_SUMMARY_DETALHAR_ENDERECO,

            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro encontrado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EnderecoResponse.class)
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
    @GetMapping("/{id}/pessoa/{idPessoa:.+}")
    public ResponseEntity<EnderecoResponse> detalhar(
            @PathVariable UUID id,
            @PathVariable UUID idPessoa
    ) {

        var endereco = enderecoService.detalhar(
                id,
                idPessoa
        );

        return ResponseEntity.ok(
                EnderecoResponse.fromEnderecoToResponse(endereco)
        );
    }

    @Operation(
            summary = Swagger.API_ENDERECO_OPERATION_SUMMARY_EXCLUIR_ENDERECO,
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
    @DeleteMapping("/{id}/pessoa/{idPessoa:.+}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id,
            @PathVariable UUID idPessoa
    ) {

        enderecoService.excluir(
                id,
                idPessoa
        );

        return ResponseEntity
                .noContent()
                .build();
    }


    @Operation(
            summary = Swagger.API_ENDERECO_OPERATION_SUMMARY_ATUALIZAR_ENDERECO,

            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro atualizado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EnderecoResponse.class)
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
                    content = @Content(schema = @Schema(implementation = DadosAtualizarEnderecoRequest.class))
            )
    )
    @PutMapping
    public ResponseEntity<EnderecoResponse> atualizar(
            @Valid @RequestBody DadosAtualizarEnderecoRequest request
    ) {

        var endereco = enderecoService.atualizar(
                enderecoCustomMapper.enderecoRequestToEnderecoAtualizar(
                        request
                )
        );

        return ResponseEntity.ok(
                EnderecoResponse.fromEnderecoToResponse(endereco)
        );
    }
}
