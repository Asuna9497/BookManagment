import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WelcomeReaderComponent } from './welcome-reader.component';

describe('WelcomeReaderComponent', () => {
  let component: WelcomeReaderComponent;
  let fixture: ComponentFixture<WelcomeReaderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WelcomeReaderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WelcomeReaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
