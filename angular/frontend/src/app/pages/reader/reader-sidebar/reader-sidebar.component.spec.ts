import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReaderSidebarComponent } from './reader-sidebar.component';

describe('ReaderSidebarComponent', () => {
  let component: ReaderSidebarComponent;
  let fixture: ComponentFixture<ReaderSidebarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReaderSidebarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReaderSidebarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
