import { bootstrap }      from '@angular/platform-browser-dynamic';
import { HTTP_PROVIDERS } from '@angular/http';

// Add all operators to Observable
import 'rxjs/Rx';

import { TohComponent }       from './toh/toh.component';

bootstrap(TohComponent, [HTTP_PROVIDERS]);
