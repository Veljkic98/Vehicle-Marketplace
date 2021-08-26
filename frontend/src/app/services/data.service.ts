import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Filter } from '../model/filter.model';

@Injectable({
    providedIn: 'root'
})
export class DataService {


    private filterSource = new BehaviorSubject(new Filter());
    currentMessage = this.filterSource.asObservable();

    constructor() { }

    sendFilter(filter: Filter) {
        this.filterSource.next(filter)
    }

}