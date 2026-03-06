import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDossier } from './add-dossier';

describe('AddDossier', () => {
  let component: AddDossier;
  let fixture: ComponentFixture<AddDossier>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AddDossier]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddDossier);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
