package br.com.fsales.eletrotech.eletrodomestico.presentation;

import br.com.fsales.eletrotech.eletrodomestico.aplication.service.EletrodomesticoService;
import br.com.fsales.eletrotech.eletrodomestico.presentation.dto.DadosAtualizarEletrodomesticoRequest;
import br.com.fsales.eletrotech.eletrodomestico.presentation.dto.EletrodomesticoRequest;
import br.com.fsales.eletrotech.eletrodomestico.presentation.dto.EletrodomesticoResponse;
import br.com.fsales.eletrotech.eletrodomestico.presentation.dto.ListarEletrodomesticoRequest;
import br.com.fsales.eletrotech.eletrodomestico.presentation.openapi.Swagger;
import br.com.fsales.eletrotech.eletrodomestico.presentation.util.EletrodomesticoCustomerMapper;
import br.com.fsales.eletrotech.infrastructure.exception.dto.Violation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
        name = Swagger.API_ELETRODOMESTICO_TAG_NAME,
        description = Swagger.API_ELETRODOMESTICO_TAG_DESCRIPTION
)

@RestController
@RequestMapping("eletrodomesticos")
@RequiredArgsConstructor

@Log4j2
@Validated
public class EletrodomesticoController {

    private final EletrodomesticoService eletrodomesticoService;

    private final EletrodomesticoCustomerMapper eletrodomesticoCustomerMapper;


    @Operation(
            summary = Swagger.API_ELETRODOMESTICO_OPERATION_SUMMARY_LISTAR_ELETRODOMESTICO,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro encontrado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EletrodomesticoResponse.class)
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
    public ResponseEntity<Page<EletrodomesticoResponse>> listar(
            @Parameter(hidden = true) @PageableDefault Pageable pageable,
            ListarEletrodomesticoRequest request
    ) {

        var page = eletrodomesticoService.consultaPaginada(
                pageable,
                eletrodomesticoCustomerMapper.listarEletrodomesticoRequestToFiltroListarEletrodomestico(
                        request
                )
        );
        return ResponseEntity.ok(
                page.map(
                        eletrodomesticoCustomerMapper::eletrodomesticoToEletrodomesticoResponse
                )
        );
    }

    @Operation(
            summary = Swagger.API_ELETRODOMESTICO_OPERATION_SUMMARY_CRIAR_ELETRODOMESTICO,

            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Registro criado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EletrodomesticoResponse.class)
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
                    content = @Content(schema = @Schema(implementation = EletrodomesticoRequest.class))
            )
    )
    @PostMapping
    public ResponseEntity<EletrodomesticoResponse> cadastrar(
            @Valid @RequestBody EletrodomesticoRequest request,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        log.debug(
                "Dados request: {}",
                request.toString()
        );

        var eletrodomestico = eletrodomesticoService.cadastrar(
                eletrodomesticoCustomerMapper.eletrodomesticoRequestToEletrodomesticoCadastro(
                        request
                )
        );

        var uri = uriComponentsBuilder.path(
                "/eletrodomesticos/{id}"
        ).buildAndExpand(
                eletrodomestico.id()
        ).toUri();

        return ResponseEntity
                .created(
                        uri
                ).body(
                        eletrodomesticoCustomerMapper.eletrodomesticoToEletrodomesticoResponse(eletrodomestico)
                );
    }


    @Operation(
            summary = Swagger.API_ELETRODOMESTICO_OPERATION_SUMMARY_DETALHAR_ELETRODOMESTICO,

            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro encontrado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EletrodomesticoRequest.class)
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
    public ResponseEntity<EletrodomesticoResponse> detalhar(
            @Schema(name = "id",
                    example = "afd74beb-eeca-47b0-8cf5-1e16a7fa40a5"
            )
            @PathVariable UUID id
    ) {
        log.debug(
                "Dados request: {}",
                id
        );

        return ResponseEntity.ok(
                eletrodomesticoCustomerMapper.eletrodomesticoToEletrodomesticoResponse(
                        eletrodomesticoService.detalhar(id)
                )
        );
    }

    @Operation(
            summary = Swagger.API_ELETRODOMESTICO_OPERATION_SUMMARY_EXCLUIR_ELETRODOMESTICO,
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
            @Schema(name = "id",
                    example = "afd74beb-eeca-47b0-8cf5-1e16a7fa40a5"
            )
            @PathVariable UUID id
    ) {

        log.debug(
                "Dados request: {}",
                id
        );
        eletrodomesticoService.excluir(id);

        return ResponseEntity
                .noContent()
                .build();
    }

    @Operation(
            summary = Swagger.API_ELETRODOMESTICO_OPERATION_SUMMARY_ATUALIZAR_ELETRODOMESTICO,

            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Registro atualizado",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EletrodomesticoResponse.class)
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
                    content = @Content(schema = @Schema(implementation = DadosAtualizarEletrodomesticoRequest.class))
            )
    )
    @PutMapping
    public ResponseEntity<EletrodomesticoResponse> atualizar(
            @Valid @RequestBody DadosAtualizarEletrodomesticoRequest request
    ) {

        log.debug(
                "Dados request: {}",
                request
        );

        var eletrodomestico = eletrodomesticoService.atualizar(
                eletrodomesticoCustomerMapper.eletrodomesticoRequestToEletrodomesticoAtualizar(
                        request
                )
        );


        return ResponseEntity.ok(
                eletrodomesticoCustomerMapper.eletrodomesticoToEletrodomesticoResponse(
                        eletrodomestico
                )
        );
    }

}
