import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchbookformComponent } from './searchbookform.component';

describe('SearchbookformComponent', () => {
  let component: SearchbookformComponent;
  let fixture: ComponentFixture<SearchbookformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchbookformComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchbookformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
