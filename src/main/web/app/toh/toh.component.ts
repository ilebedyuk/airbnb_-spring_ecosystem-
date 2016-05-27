//import { Component }         from '@angular/core';
import { HTTP_PROVIDERS }    from '@angular/http';

import { HeroListComponent } from './../usersList/hero-list.component.ts';
import { HeroLoginComponent } from './../login/user-login.component.ts';
import { HeroService }       from './../services/user.service.ts';
import { Links } from './../model/links';

import { provide }           from '@angular/core';
import { XHRBackend }        from '@angular/http';

// in-memory web api imports
//import { InMemoryBackendService,
//    SEED_DATA }          from 'angular2-in-memory-web-api/core';
//import { HeroData }          from '../hero-data';

@Component ({
    selector: 'my-toh',
    template: `
  <hero-login></hero-login>
  `,
    directives: [HeroLoginComponent],
    providers:  [
        HTTP_PROVIDERS,
        HeroService,
        Links
        //// in-memory web api providers
        //provide(XHRBackend, { useClass: InMemoryBackendService }), // in-mem server
        //provide(SEED_DATA,  { useClass: HeroData }) // in-mem server data
    ]
})
export class TohComponent {}
