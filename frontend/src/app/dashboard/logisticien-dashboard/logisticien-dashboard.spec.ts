import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogisticienDashboard } from './logisticien-dashboard';

describe('LogisticienDashboard', () => {
  let component: LogisticienDashboard;
  let fixture: ComponentFixture<LogisticienDashboard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LogisticienDashboard]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LogisticienDashboard);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
