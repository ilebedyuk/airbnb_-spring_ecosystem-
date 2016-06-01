package org.airbnb.controller;

import org.airbnb.domain.Country;
import org.airbnb.exeptions.CountryNotFoundException;
import org.airbnb.services.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.airbnb.utils.Util.getLinks;
import static org.airbnb.utils.Util.getMetadata;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author ilebedyuk
 */
@RestController
public class CountryController {
    @Inject
    private CountryService countryService;


    @RequestMapping(value = "/countries", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedResources findAll(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                  @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        Page<Country> countriesPage = countryService.findAll(new PageRequest(page, size));

        List<Resource<Country>> countries = countriesPage.getContent().stream()
                .map(this::convert)
                .collect(toList());
        return new PagedResources<>(countries, getMetadata(countriesPage), getLinks(countriesPage));
    }

    @RequestMapping(value = "/countries/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Country findOne(@PathVariable("id") long countryId) {
        Country country = countryService.findOne(countryId);
        if (country == null) throw new CountryNotFoundException();
//        country.add(linkTo(methodOn(CountryController.class).findOne(countryId)).withSelfRel());
        return country;
    }

    private Resource<Country> convert(Country country) {
        Resource<Country> resource = new Resource<>(country);
        resource.add(linkTo(CountryController.class).slash(country.getCountryId()).withSelfRel());
        return resource;
    }
}
