package br.com.fsales.eletrotech.dominio.endereco.controller;

import br.com.fsales.eletrotech.dominio.endereco.controller.openapi.Swagger;
import br.com.fsales.eletrotech.dominio.endereco.dto.DadosAtualizarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.dto.EnderecoResponse;
import br.com.fsales.eletrotech.dominio.endereco.dto.ListarEnderecoRequest;
import br.com.fsales.eletrotech.dominio.endereco.service.EnderecoService;
import br.com.fsales.eletrotech.dominio.endereco.util.EnderecoCustomerMapper;
import br.com.fsales.eletrotech.infrastructure.handler.exception.dto.Violation;
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

    private final EnderecoCustomerMapper enderecoMapper;

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
    public ResponseEntity<Page<EnderecoResponse>> listar(
            ListarEnderecoRequest request,
            @Parameter(hidden = true) @PageableDefault(page = 0, size = 10) Pageable pageable
    ) {

        var enderecoPage = enderecoService.consultaPaginada(
                request,
                pageable
        );

        return ResponseEntity.ok(
                enderecoPage.map(enderecoProjection -> enderecoMapper.enderecoProjectionToEnderecoResponse(enderecoProjection))
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
                request
        );


        var uri = uriComponentsBuilder.path(
                "/enderecos/{id}"
        ).buildAndExpand(
                endereco.getId()
        ).toUri();

        return ResponseEntity
                .created(
                        uri
                ).body(
                        EnderecoDtoMapper.fromEnderecoToResponse(endereco)
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
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponse> detalhar(
            @PathVariable UUID id
    ) {

        var endereco = enderecoService.detalhar(id);

        return ResponseEntity.ok(
                EnderecoDtoMapper.fromEnderecoToResponse(endereco)
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
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable UUID id
    ) {

        enderecoService.excluir(id);

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

        var endereco = enderecoService.atualizar(request);

        return ResponseEntity.ok(
                EnderecoDtoMapper.fromEnderecoToResponse(endereco)
        );
    }
}
