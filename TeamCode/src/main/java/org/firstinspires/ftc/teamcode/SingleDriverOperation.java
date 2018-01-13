package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Single Driver", group="Default")
public class SingleDriverOperation extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    HWMap robot = new HWMap();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.claw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        while (opModeIsActive()) {
            robot.rightDrive.setPower(gamepad1.right_stick_y);
            robot.leftDrive.setPower(gamepad1.left_stick_y);
            if (gamepad1.dpad_up) {
                robot.clawWinch.setPower(0.75);
            } else if (gamepad1.dpad_down) {
                robot.clawWinch.setPower(-0.75);
            } else {
                robot.clawWinch.setPower(0);
            }

            if (gamepad1.a) {
                robot.claw.setPower(-0.15);
            } else if (gamepad1.b) {
                robot.claw.setPower(0.15);
            } else {
                robot.claw.setPower(0);
            }
        }
    }
}
