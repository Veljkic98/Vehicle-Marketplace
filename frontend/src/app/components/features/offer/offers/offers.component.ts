import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Filter } from 'src/app/model/filter.model';
import { OfferRes } from 'src/app/model/offerRes.model';
import { DataService } from 'src/app/services/data.service';
import { OfferService } from 'src/app/services/offer.service';

@Component({
  selector: 'app-offers',
  templateUrl: './offers.component.html',
  styleUrls: ['./offers.component.css']
})
export class OffersComponent implements OnInit {

  // subscription: Subscription;
  offers: Array<OfferRes> = [];
  row1: Array<OfferRes> = [];
  row2: Array<OfferRes> = [];

  rest = false;

  constructor(
    private offerService: OfferService,
  ) { }

  ngOnInit(): void {
    this.loadOffers();
  }

  loadOffers() {
    this.offerService.getAll(0, 5).subscribe(
      res => {
        this.offers = res.content
        // console.log(res)

        var help = true;
        for (var o of this.offers) {
          if (help) this.row1.push(o);
          else this.row2.push(o);

          if (help) help = false;
          else help = true;
        }


        if ((res.size % 2) == 1) this.rest = true;
        else this.rest = false;
      }

    )
  }

  ngOnDestroy() {
    // this.subscription.unsubscribe();
  }

}
