import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-offer',
  templateUrl: './offer.component.html',
  styleUrls: ['./offer.component.css']
})
export class OfferComponent implements OnInit {

  val = ""
  subscription: Subscription;

  constructor(
    private data: DataService,
  ) { }

  ngOnInit(): void {
    this.subscription = this.data.currentMessage.subscribe(message => this.val = message)
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
