--
-- File generated with SQLiteStudio v3.3.2 on Mon Mar 29 14:34:53 2021
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: Class Schedule
DROP TABLE IF EXISTS "Class Schedule";
CREATE TABLE "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code");
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('TRANSITION TO KEAN', 'M W F', '9:30AM - 10:45AM', '1', 'GE 1000');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('TRANFER TRANSITIONS', 'T TR', '12:30PM-1:45PM', '1', 'GE 3000');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('COLLEGE COMPOSITION', 'T TR', '9:30AM - 10:45AM', '3', 'ENG 1030');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('PRE -CALCULUS', 'T TR', '11:00AM -12:15PM', '3', 'MATH 1054');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('COMMUNICATION AS CRITICAL CITIZENSHIP', 'M W F', '12:30PM-1:45PM', '3', 'COMM 1402');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('RESEARCH AND TECHNOLOGY', 'M W F', '9:30AM - 10:45AM', '3', 'GE 2024');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('WORLD LITERATATURE', 'T TR', '9:30AM - 10:45AM', '3', 'ENG 2403');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('WORLDS OF HISTORY: TRADITIONS AND ENCOUNTERS', 'T TR', '4:30PM-5:45PM', '3', 'HIST1062');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('FUNDAMENTALS OF COMPUTER SCIENCE', 'M W F', '12:30PM-1:45PM', '3', 'CPS 1231');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('COMPUTER SYSTEMS', 'T TR', '4:30PM-5:45PM', '3', 'TECH 2920');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('TECHNICAL WRITING', 'T TR', '4:30PM-5:45PM', '3', 'ENG 3091');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('CALCULUS I', 'T TR', '12:30PM-1:45PM', '4', 'MATH 2415');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('CALCULUS II', 'T ', '12:30PM - 4:00:PM', '4', 'MATH 2416');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('APPLIES STATISTICS I', 'T TR', '9:30AM - 10:45AM', '3', 'MATH 2526');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('CALCULUS III', 'T ', '12:00PM - 3:15PM', '4', 'MATH 3415');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('APPLIED STATISTICS II', 'T TR', '2:30PM-3:15PM', '3', 'MATH 3526');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('COMPUTER ORGANIATION & PROGAMMING', 'M W F', '11:00AM -12:15PM', '4', 'CPS 2231');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('DATA STRUCTURES AND ALGORITHMS', 'TR', '12:00PM - 3:15PM', '4', 'CPS 2232');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('COMPUTER ORGANZATIPN & ARCHITECTURE', 'T TR', '2:30PM-3:15PM', '3', 'CPS 2390');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('COMPUTER OPERATING SYSTEMS', 'T TR', '9:30AM - 10:45AM', '3', 'CPS 3250');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('ANALYSIS OF ALGORITHMS', 'M W F', '4:30PM-5:45PM', '3', 'CPS 3440');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('OBJECT ORIENTED ANALYSIS AND DESIGN', 'T TR', '9:30AM - 10:45AM', '3', 'CPS 3962');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('COMPUTER ARCHITECTURE', 'M W F', '9:30AM - 10:45AM', '3', 'CPS 4150');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('PRINCIPLES OF NETWORKING', 'T TR', '12:30PM-1:45PM', '3', 'CPS 4222');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('SENIOR CAPSTONE', 'M W F', '2:30PM-3:15PM', '3', 'CPS 4951');
INSERT INTO "Class Schedule" ("Course name", "Meeting Days", "Meeting time", Credits, "Course Code") VALUES ('FINE ARTS', 'M W F', '2:30PM-3:15PM', '3', 'CPS 4952');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
