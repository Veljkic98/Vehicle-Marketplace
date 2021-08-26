import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Filter } from 'src/app/model/filter.model';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {

  val = ""
  filter: Filter = new Filter();

  subscription: Subscription;

  constructor(
    private data: DataService,
  ) { }

  ngOnInit(): void {
    this.subscription = this.data.currentMessage.subscribe(filter =>{
      this.filter = filter;
    })
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
