import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SerachPurchasedBookComponent } from './serach-purchased-book.component';

describe('SerachPurchasedBookComponent', () => {
  let component: SerachPurchasedBookComponent;
  let fixture: ComponentFixture<SerachPurchasedBookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SerachPurchasedBookComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SerachPurchasedBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
