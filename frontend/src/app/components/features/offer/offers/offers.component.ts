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

  page = 0;
  size = 3;
  totalPages = 0;

  currentPage = 0;
  disablePrevious = true;
  disableNext = false;

  rest = false;

  constructor(
    private offerService: OfferService,
  ) { }

  ngOnInit(): void {
    this.loadOffers();
  }

  loadOffers() {
    this.offerService.getAll(this.page, this.size).subscribe(
      res => {
        console.log(res)
        this.row1 = [];
        this.row2 = [];

        if (res.totalElements == res.size) this.disableNext = true;
        this.totalPages = res.totalPages;

        this.offers = res.content

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

  next() {
    this.page = this.page + 1;
    
    this.disablePrevious = false;

    if ((this.page + 1) == this.totalPages) this.disableNext = true;

    this.loadOffers();

  }

  previous() {
    this.page = this.page - 1;

    if (this.page == 0) this.disablePrevious = true;
    if ((this.page + 1) < this.totalPages) this.disableNext = false;

    this.loadOffers();
  }

  ngOnDestroy() {
    // this.subscription.unsubscribe();
  }

}
