package com.kristileka.eucurrencyconverter.controller;

import com.kristileka.eucurrencyconverter.config.exceptions.ErrorResponse;
import com.kristileka.eucurrencyconverter.domain.dto.request.average.CurrencyAverageRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.conversion.CurrencyConversionRequest;
import com.kristileka.eucurrencyconverter.domain.dto.request.record.CurrencyRecordRequest;
import com.kristileka.eucurrencyconverter.domain.dto.response.average.CurrencyAverageResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.conversion.CurrencyConversionResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.daily.DailyCurrencyResponse;
import com.kristileka.eucurrencyconverter.domain.dto.response.record.CurrencyRecordResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kristileka.eucurrencyconverter.domain.CurrencyService;
@RestController("Manage Currency Operations.")
@RequestMapping("api/")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;


    @Operation(summary = "Get all currency rates by day, if the date is missing it will redirect to current day.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Currencies retrieved successfully!", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = DailyCurrencyResponse.class))}), @ApiResponse(responseCode = "400", description = "Date added into the request is invalid.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}), @ApiResponse(responseCode = "404", description = "There were no currencies at the given date," + " make sure to use a weekday.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
    @GetMapping("/currency")
    public ResponseEntity<DailyCurrencyResponse> getCurrencyByDate(@RequestParam("date") Optional<String> date) {
        return ResponseEntity.ok(currencyService.getCurrenciesByDate(date));
    }

    @Operation(summary = "Convert a currency amount to a target currency")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Conversion was successful!", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyConversionRequest.class))}), @ApiResponse(responseCode = "400", description = "Date added into the request is invalid.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}), @ApiResponse(responseCode = "404", description = "Currency does not exist or there is no currency at the given date," + " make sure to use a weekday.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
    @PostMapping("/currency")
    public ResponseEntity<CurrencyConversionResponse> convertCurrency(@Valid @RequestBody CurrencyConversionRequest body) {
        return ResponseEntity.ok(currencyService.convertCurrency(body));
    }

    @Operation(summary = "Find best record for a currency at a time range.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Record retrieved successfully!", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyRecordResponse.class))}), @ApiResponse(responseCode = "400", description = "Start or end date added into the requests are invalid.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}), @ApiResponse(responseCode = "404", description = "Given dates or currency are incorrect," + " make sure to use a weekday.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
    @PostMapping("/currency/record")
    public ResponseEntity<CurrencyRecordResponse> getCurrencyRecord(@Valid @RequestBody CurrencyRecordRequest body) {
        return ResponseEntity.ok(currencyService.getCurrencyRecord(body));
    }

    @Operation(summary = "Find average rate for a currency at a time range.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Average rate retrieved successfully!", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyRecordResponse.class))}), @ApiResponse(responseCode = "400", description = "Start or end date added into the requests are invalid.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}), @ApiResponse(responseCode = "404", description = "Given dates or currency are incorrect," + " make sure to use a weekday.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})})
    @PostMapping("/currency/average")
    public ResponseEntity<CurrencyAverageResponse> getCurrencyAverage(@Valid @RequestBody CurrencyAverageRequest body) {
        return ResponseEntity.ok(currencyService.getCurrencyAverage(body));
    }
}
