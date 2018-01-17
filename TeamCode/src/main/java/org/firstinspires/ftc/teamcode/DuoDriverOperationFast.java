package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Duo Driver Fast", group="Fast")
public class DuoDriverOperationFast extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    HWMap robot = new HWMap();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.claw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        while (opModeIsActive()) {
            robot.rightDrive.setPower(gamepad1.right_stick_y*1);
            robot.leftDrive.setPower(gamepad1.left_stick_y*1);
            robot.clawWinch.setPower(gamepad2.left_stick_y);

            if (gamepad2.a && gamepad2.right_bumper) {
                robot.claw.setPower(-0.4);
            } else if (gamepad2.b && gamepad2.right_bumper) {
                robot.claw.setPower(0.4);
            } else if (gamepad2.a) {
                robot.claw.setPower(-0.2);
            } else if (gamepad2.b) {
                robot.claw.setPower(0.2);
            } else {
                robot.claw.setPower(0);
            }
        }
    }
}
