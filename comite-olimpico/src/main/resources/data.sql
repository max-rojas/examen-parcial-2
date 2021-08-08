-- AthleteDetails
insert into athlete_details(id, sport, height, weight, gender)
values(20000, 'soccer', 178, 93.5, 'M');

-- Athletes
insert into athlete(id, full_name, last_name, second_last_name, date_of_birth, phone_number, email, city, district, province, athlete_details_id)
values(10000, 'Max', 'Rojas', 'Torres', sysdate(), '86110962', 'mrojast@ucenfotec.ac.cr', 'Ulloa', 'Heredia', 'Heredia', 20000);

-- Indice de Masa Corporal
insert into body_mass_index(id, bmi_value, measurement_date, athlete_details_id)
values(30000, 32.5, sysdate(), 20000);
insert into body_mass_index(id, bmi_value, measurement_date, athlete_details_id)
values(30001, 35, sysdate(), 20000);

