import { Http, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { AbstractConcreteService } from '@concrete/AbstractConcreteService';


@Injectable()
export class ExampleApi extends AbstractConcreteService {

    constructor (private http: Http) {
        super();
    }


    public aclTest(): Observable<string> {
        return this.http.request(this.$$getServiceRoot() + `/Example/aclTest`, this.defaultRequestOptions('GET'))
                .map(this.extractData)
                .catch(this.handleError);
    }
    public add(x1: number, x2: number): Observable<number> {
        return this.http.request(this.$$getServiceRoot() + `/Example/add/${x1}/${x2}`, this.defaultRequestOptions('GET'))
                .map(this.extractData)
                .catch(this.handleError);
    }
    public getRandomVeh(id: string): Observable<string> {
        return this.http.request(this.$$getServiceRoot() + `/Example/vehicles/${id}`, this.defaultRequestOptions('GET'))
                .map(this.extractData)
                .catch(this.handleError);
    }
}
