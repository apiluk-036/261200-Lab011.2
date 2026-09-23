# 261200-Lab11_2 — Drop Game Extended (LibGDX)

โปรเจกต์ต่อยอดจากบทเรียน [Extending the Simple Game](https://libgdx.com/wiki/start/simple-game-extended)
ของ LibGDX — เพิ่มหน้าเมนู (MainMenuScreen) และหน้าเกม (GameScreen) โดยใช้ Game + Screen แทน ApplicationAdapter เดิม

## สิ่งที่ทำตามโจทย์ (แก้ไขจากตัวอย่างในบทเรียน)

1. **MainMenuScreen** — เปลี่ยน event เปลี่ยนหน้าจอ จาก `Gdx.input.isTouched()`
   เป็นการกดปุ่ม **SPACE** (`Gdx.input.isKeyPressed(Input.Keys.SPACE)`)
   และแก้ข้อความบนจอเป็น `"Press SPACE to begin!"`
2. **GameScreen** — ในเมธอด `createDroplet()` ทำให้ขนาดหยดน้ำแต่ละหยด
   สุ่มขนาด (กว้าง/สูง) ตอน spawn แทนที่จะเป็น 1x1 คงที่
   (สุ่มด้วย `MathUtils.random(MIN_DROP_SIZE, MAX_DROP_SIZE)`)

## โครงสร้างไฟล์

```
drop-game-extended/
├── build.gradle
├── settings.gradle
├── .gitignore
└── core/
    ├── src/main/java/com/mygdx/game/
    │   ├── Drop.java             (Game class, entry point)
    │   ├── MainMenuScreen.java   (หน้าเมนู — กด SPACE เพื่อเริ่ม)
    │   ├── GameScreen.java       (หน้าเกมหลัก — หยดน้ำขนาดสุ่ม)
    │   └── DesktopLauncher.java  (จุดเริ่มรันบน Desktop)
    └── assets/                   (ใส่ไฟล์รูป/เสียงที่นี่ — ดูด้านล่าง)
```

## สิ่งที่ต้องเพิ่มเอง: assets

โค้ดอ้างอิงไฟล์ 5 ไฟล์ที่ต้องโหลดจากหน้า tutorial แล้วนำมาวางใน `core/assets/`:

- `background.png`
- `bucket.png`
- `drop.png`
- `drop.mp3`
- `music.mp3`

ดาวน์โหลด asset pack ได้จากหน้า
https://libgdx.com/wiki/start/simple-game-extended (หรือหน้า a-simple-game ถ้าใช้ asset pack เดียวกัน)

## วิธีรัน

```bash
./gradlew run
```

## วิธีอัปโหลดขึ้น GitHub (ต้องทำเองในเครื่อง เพราะ Claude ไม่มีสิทธิ์เข้าบัญชี GitHub ของคุณ)

1. ไปที่ https://github.com/new
2. ตั้งชื่อ repository เป็น `261200-Lab11_2`
3. เลือก **Public** (ถ้าเลือก Private งานจะไม่ถูกตรวจ)
4. **ห้าม** ติ๊กสร้าง README/.gitignore/license ใน UI (เรามีไฟล์พวกนี้แล้ว) แล้วกด Create repository
5. ในเครื่องคุณ เปิด terminal ที่โฟลเดอร์โปรเจกต์นี้แล้วรัน:

```bash
git init
git add .
git commit -m "Lab 11_2: LibGDX extended drop game (SPACE menu + random drop size)"
git branch -M main
git remote add origin https://github.com/<your-username>/261200-Lab11_2.git
git push -u origin main
```

6. รีเฟรชหน้า repo บนเว็บ ตรวจว่าไฟล์ขึ้นครบและ repo เป็น Public
7. คัดลอกลิงก์ `https://github.com/<your-username>/261200-Lab11_2` ไปส่งเป็นคำตอบ
