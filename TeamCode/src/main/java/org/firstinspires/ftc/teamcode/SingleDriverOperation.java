package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Single Driver", group="Default")
public class SingleDriverOperation extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    HWMap robot = new HWMap();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
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
                robot.claw.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.claw.setTargetPosition(0);
                robot.claw.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                while(robot.claw.isBusy()){}
                robot.claw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            } else if (gamepad1.b) {
                robot.claw.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                robot.claw.setTargetPosition(45);
                robot.claw.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                while(robot.claw.isBusy()){}
                robot.claw.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }
        }
    }
}
